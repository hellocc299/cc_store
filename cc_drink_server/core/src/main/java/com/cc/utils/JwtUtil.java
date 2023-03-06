package com.cc.utils;

import com.cc.Exception.BusinessException;
import com.cc.VO.StaffLoginVO;
import com.cc.constants.JwtConstants;
import com.cc.entity.StaffLogin;
import com.cc.entity.User;
import com.cc.repository.UserRepository;
import com.cc.response.ErrorEnum;
import com.cc.response.R;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @Author CC
 * @Date 2022/12/6
 */
@Component
public class JwtUtil {
    // jwt令牌的秘钥
    @Value("${jwt.secret}")
    private String secret;
    // token的实效时间
    @Value("${jwt.expiration}")
    private Long expiration;

    @Value("${jwt.refresh_expiration}")
    private Long refreshExpiration;

    @Autowired
    private UserRepository userRepository;

    /**
     * 根据用户信息生成token
     *
     * @param staffLogin
     * @return
     */
    public String generateStaffLoginToken(StaffLogin staffLogin) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtConstants.STAFF_LOGIN_USERNAME, staffLogin.getUsername());
        claims.put(JwtConstants.STAFF_LOGIN_PASSWORD, staffLogin.getPassword());
        claims.put(JwtConstants.STAFF_LOGIN_TOKEN_CREATED, new Date());
        return generateToken(claims);
    }

    /**
     * 根据用户信息生成token
     *
     * @param user
     * @return
     */
    public String generateUserToken(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtConstants.WX_LOGIN_ID, user.getId());
        return generateToken(claims);
    }

    /**
     * 从token获取用户信息
     * @param token
     * @return
     */
    public StaffLogin getStaffLoginFromToken(String token){
        StaffLogin staffLogin = new StaffLogin();
        Map<String , Object> claims = getClaimsFromToken(token);
        System.out.println(claims);
        try {
            String username = (String) claims.get(JwtConstants.STAFF_LOGIN_USERNAME);
            String password = (String) claims.get(JwtConstants.STAFF_LOGIN_PASSWORD);
            staffLogin.setUsername(username);
            staffLogin.setPassword(password);
            return staffLogin;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 从token获取user信息
     * @param token
     * @return
     */
    public User getUserFromToken(String token){
        Map<String , Object> claims = getClaimsFromToken(token);
        try {
            Integer userId = (Integer) claims.get(JwtConstants.WX_LOGIN_ID);
            User user = userRepository.findUserById(userId);
            return user;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * staffLogin token是否有效
     * @param token
     * @param staffLogin
     * @return
     */
    public Boolean validateStaffToken(String token,StaffLogin staffLogin){
        StaffLogin user = getStaffLoginFromToken(token);
        return user.getUsername().equals(staffLogin.getUsername())
                && user.getPassword().equals(staffLogin.getPassword())
                && !isTokenExpired(token);
    }

    /**
     * user token是否有效
     * @param token
     * @param user
     * @return
     */
    public Boolean validateUserToken(String token,User user){
        User tokenUser = getUserFromToken(token);
        return user.getId().equals(tokenUser.getId())
                && user.getOpenId().equals(user.getOpenId())
                && !isTokenExpired(token);
    }

    /**
     * 根据用户名生成refreshToken
     * @param userName
     * @return
     */
    public String generateStaffLoginRefreshToken(String userName){
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtConstants.STAFF_LOGIN_USERNAME, userName);
        claims.put(JwtConstants.STAFF_LOGIN_TOKEN_CREATED, new Date());
        return generateRefreshToken(claims);
    }

    /**
     * user根据openId生成refreshToken
     * @param openId
     * @return
     */
    public String generateUserRefreshToken(String openId){
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtConstants.WX_OPEN__ID, openId);
        claims.put(JwtConstants.WX_LOGIN_TOKEN_CREATED, new Date());
        return generateRefreshToken(claims);
    }

    /**
     * 更新token
     * @param
     * @return
     */
    public String refreshStaffToken(String token){
        Claims claims = getClaimsFromToken(token);
        claims.put(JwtConstants.STAFF_LOGIN_TOKEN_CREATED, new Date());
        return generateToken(claims);
    }

    /**
     * 更新token
     * @param
     * @return
     */
    public String refreshUserToken(String token){
        Claims claims = getClaimsFromToken(token);
        claims.put(JwtConstants.WX_LOGIN_TOKEN_CREATED, new Date());
        return generateToken(claims);
    }



    /**
     * 判断token是否失效
     * @param token
     * @return
     */
    public boolean isTokenExpired(String token) {
        Date expireDate = getExpiredDateFromToken(token);
        //如果token有效的时间在当前时间之前就表示失效
        return expireDate.before(new Date());
    }

    /**
     * 判断refreshToken是否失效
     * @param refreshToken
     * @return
     */
    public boolean isrefreshTokenExpired(String refreshToken) {
        Date expireDate = getExpiredDateFromRefreshToken(refreshToken);
        //如果token有效的时间在当前时间之前就表示失效
        return expireDate.before(new Date());
    }

    /**
     * 从token中获取实效时间
     * @param token
     * @return
     */
    private Date getExpiredDateFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return claims.getExpiration();
    }

    /**
     * 从refreshToken中获取实效时间
     * @param refreshToken
     * @return
     */
    private Date getExpiredDateFromRefreshToken(String refreshToken) {
        Claims claims = getClaimsFromToken(refreshToken);
        return claims.getExpiration();
    }

    /**
     * 根据token获取荷载
     * @param token
     * @return
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return claims;
    }

    /**
     * 根据荷载生成JWTToken
     *
     * @param claims
     * @return
     */
    private String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpiration())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 根据荷载生成JWTToken
     *
     * @param claims
     * @return
     */
    private String generateRefreshToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateRefreshTokenExpiration())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 生成token实效时间
     *
     * @return
     */
    private Date generateExpiration() {
        // 当前时间+配置时间
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    /**
     * 生成RefreshToken实效时间
     *
     * @return
     */
    private Date generateRefreshTokenExpiration() {
        // 当前时间+配置时间
        return new Date(System.currentTimeMillis() + refreshExpiration * 1000);
    }

}