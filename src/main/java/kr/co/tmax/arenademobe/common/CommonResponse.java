package kr.co.tmax.arenademobe.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> {
    private String message;
    private T data;

    public static <T> CommonResponse<T> withMessageAndData(String message, T data) {
        return (CommonResponse<T>) CommonResponse.builder()
                .message(message)
                .data(data)
                .build();
    }

    public static <T> CommonResponse<T> withMessage(String message) {
        return (CommonResponse<T>) CommonResponse.builder()
                .message(message)
                .data(null)
                .build();
    }
}
