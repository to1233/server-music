package com.example.music.constant;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/8/13 17:15
 * @Description
 */
@Data
@NoArgsConstructor
public class SysConstant {

    public static final String MANAGEMENT_AUTH = "management_auth";
    public static final String X_FORWARDED_FOR = "x_forwarded_for";
    public static final String TOKEN = "token";

    /* 歌曲图片，歌手图片，歌曲文件，歌单图片等文件的存放路径 */
    public static String PROJECT_PATH = System.getProperty("user.dir");

    public static String AVATOR_IMAGES_PATH = "file:" + PROJECT_PATH + "/img/avatorImages/";
    public static String SONGLIST_PIC_PATH = "file:" + PROJECT_PATH + "/img/songListPic/";
    public static String SONG_PIC_PATH = "file:" + PROJECT_PATH + "/img/songPic/";
    public static String SONG_PATH = "file:" + PROJECT_PATH + "/song/";
    public static String SINGER_PIC_PATH = "file:" + PROJECT_PATH + "/img/singerPic/";

    @NoArgsConstructor(access =  AccessLevel.PRIVATE)
    public static class DbColumnKey {
        public static final String NAME = "name";
        public static final String PHONE = "phone";
        public static final String SONG_ID = "song_id";
        public static final String SONG_LIST_ID = "song_list_id";
        public static final String SINGER_ID = "singer_id";
        public static final String STYLE = "style";
        public static final String TITLE = "title";
        public static final String CONSUMER_ID = "consumer_id";
        public static final String SCORE = "score";
    }
}
