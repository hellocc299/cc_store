package com.cc.service.impl;

import com.cc.Exception.BusinessException;
import com.cc.response.ErrorEnum;
import com.cc.response.R;
import com.cc.service.VerifyCodeService;
import com.cc.utils.RedisUtil;
import com.cc.utils.VerifyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.time.Duration;

/**
 * @Author CC
 * @Date 2022/11/4
 */

@Service
public class VerifyCodeServiceImpl implements VerifyCodeService {
    @Autowired
    RedisUtil redisUtil;
    /**
     * 生成图片验证码
     * @param response
     * @param request
     * @throws IOException
     */
    @Override
    public void createCode(HttpServletResponse response, HttpServletRequest request) throws IOException {
        //获取session
        HttpSession session = request.getSession();
        //获得sessionId
        String id = session.getId();
        ResponseCookie cookie = ResponseCookie.from("JSESSIONID",id)
                .secure(true)
                .domain("")
                .path("/")
                .maxAge(Duration.ofHours(1))
                .sameSite("None")
                .build();
        //清除之前缓存的图片验证码
        if (!String.valueOf(request.getSession().getAttribute("SESSION_VERIFY_CODE_"+id)).isEmpty()){
            String getVerify = String.valueOf(request.getSession().getAttribute("SESSION_VERIFY_CODE_"+id));
            redisUtil.del(getVerify);
            System.out.println("清除成功");
        }
        //生成图片验证码,用的默认参数
        Object[] verify = VerifyUtil.newBuilder().build().createImage();
        String verifyCode = ((String) verify[0]).toLowerCase();
        //将验证码存入session
        session.setAttribute("SESSION_VERIFY_CODE_" + id, verifyCode);
        //打印验证码
        System.out.println(verifyCode);
        //将验证码存入redis
        redisUtil.set(verifyCode,id,5*60);
        //将图片传给浏览器
        BufferedImage image = (BufferedImage) verify[1];
        response.setContentType("image/png");
        response.setHeader(HttpHeaders.SET_COOKIE,cookie.toString());
        OutputStream ops = response.getOutputStream();
        ImageIO.write(image,"png",ops);
    }
    @Override
    public R checkCode(String verificationCode){
        if (!redisUtil.hasKey(verificationCode)){
            throw new BusinessException(ErrorEnum.E_20020);
        }
        redisUtil.del(verificationCode);
        return R.success();
    }
}
