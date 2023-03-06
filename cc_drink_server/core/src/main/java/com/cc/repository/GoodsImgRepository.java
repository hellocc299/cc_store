package com.cc.repository;

import com.cc.entity.GoodsImg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface GoodsImgRepository extends JpaRepository<GoodsImg, Integer>, JpaSpecificationExecutor<GoodsImg> {
    GoodsImg findGoodsImgByImgUrl(String imgUrl);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "update goods_img set img_url=?1 where goods_img_id=?2")
    void updateGoodsImg(String imgUrl, Integer imgId);
}
