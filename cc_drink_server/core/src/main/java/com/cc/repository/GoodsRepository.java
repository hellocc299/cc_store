package com.cc.repository;

import com.cc.entity.Goods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface GoodsRepository extends JpaRepository<Goods, Integer>, JpaSpecificationExecutor<Goods> {
    @Query(nativeQuery = true,
            value = "select g.goods_id, g.name, g.is_pull, g.price, g.description, g.c_id, g.g_i_id, cl.name as classify, cl.img_url as classify_img, gi.img_url as img, g.create_time, g.update_time " +
                    "from goods g " +
                    "left join classify cl on g.c_id = cl.classify_id " +
                    "left join goods_img gi on g.g_i_id = gi.goods_img_id " +
                    "where (?1 is null or g.name like %?1%) and (?2 is null or g.c_id = ?2) order by g.create_time",
            countQuery = "select g.goods_id, g.name, g.is_pull, g.price, g.description, g.c_id, g.g_i_id, cl.name as classify, gi.img_url as img, g.create_time, g.update_time " +
                    "from goods g " +
                    "left join classify cl on g.c_id = cl.classify_id " +
                    "left join goods_img gi on g.g_i_id = gi.goods_img_id " +
                    "where (?1 is null or g.name like %?1%) and (?2 is null or g.c_id = ?2) order by g.create_time"
    )
    Page<Map<String, Object>> findGoodsByCondition2(String name, Integer classifyId, Pageable pageable);

    Goods findGoodsByName(String name);

    @Query(nativeQuery = true,
            value = "select g.goods_id, g.name, g.is_pull, g.price, g.description, g.c_id, g.g_i_id, cl.name as classify, cl.img_url as classify_img, gi.img_url as img, g.create_time, g.update_time " +
                    "from goods g " +
                    "left join classify cl on g.c_id = cl.classify_id " +
                    "left join goods_img gi on g.g_i_id = gi.goods_img_id " +
                    "where g.c_id = ?1 order by g.create_time",
            countQuery = "select g.goods_id, g.name, g.is_pull, g.price, g.description, g.c_id, g.g_i_id, cl.name as classify, gi.img_url as img, g.create_time, g.update_time " +
                    "from goods g " +
                    "left join classify cl on g.c_id = cl.classify_id " +
                    "left join goods_img gi on g.g_i_id = gi.goods_img_id " +
                    "where g.c_id = ?1 order by g.create_time"
    )
    List<Goods> findGoodsByClassifyId(Integer id);
}
