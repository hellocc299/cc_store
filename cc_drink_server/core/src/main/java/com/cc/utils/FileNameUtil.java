package com.cc.utils;

/**
 * @Author CC
 * @Date 2023/1/31
 */
public class FileNameUtil {

        /**
         * 获取文件后缀
         * @param fileName
         * @return
         */
        public static String getSuffix(String fileName){
            return fileName.substring(fileName.lastIndexOf("."));
        }

        /**
         * 生成新的文件名
         * @param fileOriginName 源文件名
         * @return
         */
        public static String getFileName(String fileOriginName){
            return UUIDUtil.getUUID() + FileNameUtil.getSuffix(fileOriginName);
        }
}
