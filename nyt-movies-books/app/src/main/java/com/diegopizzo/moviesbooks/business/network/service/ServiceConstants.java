package com.diegopizzo.moviesbooks.business.network.service;

/**
 * Created by diegopizzo on 17/11/2017.
 */

public class ServiceConstants {

    public static final String SERVICE_ENDPOINT = "https://api.nytimes.com";
    public static final String API_KEY = "cd4c4a6002af45179911abdb6cd0abfc";


    public enum OrderMovies {
        BY_PUBBLICATION_DATE("by-publication-date"),
        BY_TITLE("by-title"),
        BY_OPENING_DATE("by-opening-date");

        private final String value;

        private OrderMovies(final String value) {
            this.value = value;
        }

        public static OrderMovies fromValue(final String value) {
            if (value == null) {
                return null;
            }
            for (final OrderMovies order : OrderMovies.values()) {
                if (order.value.equalsIgnoreCase(value)) {
                    return order;
                }
            }
            throw new IllegalArgumentException("No constant with value " + value);
        }

        public String getValue() {
            return value;
        }
    }

    public enum ResourceTypeMovies {
        ALL("all"),
        PICKS("picks");

        private final String value;

        private ResourceTypeMovies(final String value) {
            this.value = value;
        }

        public static ResourceTypeMovies fromValue(final String value) {
            if (value == null) {
                return null;
            }
            for (final ResourceTypeMovies resource : ResourceTypeMovies.values()) {
                if (resource.value.equalsIgnoreCase(value)) {
                    return resource;
                }
            }
            throw new IllegalArgumentException("No constant with value " + value);
        }

        public String getValue() {
            return value;
        }
    }

}
