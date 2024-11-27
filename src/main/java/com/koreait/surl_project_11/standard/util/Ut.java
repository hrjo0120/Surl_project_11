package com.koreait.surl_project_11.standard.util;

import com.koreait.surl_project_11.global.app.AppConfig;
import lombok.SneakyThrows;

public class Ut {
    public static class str {
        public static boolean isBlank(String str) {
            return str == null || str.isBlank();
        }

        //public static boolean isNotBlank(String str) {}
        public static boolean hasLength(String str) {
            return !isBlank(str);
        }
    }

    public static class json {
        @SneakyThrows
        public static String toString(Object obj) {    // 스프링부트에 등록되어있는 bean을 내가 활용할 수 있는 형태로 바꿀거야
            return AppConfig.getObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        }
    }
}

