package kr.co.tmax.arenademobe.common;

import kr.co.tmax.arenademobe.exception.BadRequestException;
import kr.co.tmax.arenademobe.exception.ExternalException;
import kr.co.tmax.arenademobe.exception.ResourceNotFoundException;
import kr.co.tmax.arenademobe.validator.ValidationResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.DateTimeException;
import java.util.Locale;

@RequiredArgsConstructor
@Slf4j
@RestControllerAdvice
public class CommonControllerAdvice {

    private final MessageSource messageSource;

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public CommonResponse onException(Exception e, Locale locale) {
        log.error(e.getMessage());
        return CommonResponse.withMessage("시스템 에러");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public CommonResponse onBindException(BindException e, Locale locale) {
        log.error(e.getMessage());
        return CommonResponse.withMessageAndData("잘못된 요청", ValidationResult.create(e, messageSource, locale));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public CommonResponse onBadRequestException(BadRequestException e) {
        log.error(e.getMessage());
        return CommonResponse.withMessage("잘못된 요청: " + e.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public CommonResponse onResourceNotFoundException(ResourceNotFoundException e) {
        log.error(e.getMessage());
        return CommonResponse.withMessage("잘못된 요청: " + e.getMessage());
    }

    @ResponseStatus(HttpStatus.REQUEST_TIMEOUT)
    @ExceptionHandler(ExternalException.class)
    public CommonResponse onExternalException(ExternalException e) {
        log.error(e.getMessage());
        return CommonResponse.withMessage("외부 모듈 에러");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = DateTimeException.class)
    public CommonResponse onDateTimeParseException(DateTimeException e) {
        log.error(e.getMessage());
        return CommonResponse.withMessage("날짜 및 시간 형식이 올바르지 않습니다");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public CommonResponse onDHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.error(e.getMessage());
        return CommonResponse.withMessage("HTTP 메시지 형식이 올바르지 않습니다");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public CommonResponse handleMissingServletRequestParameterException(MissingServletRequestParameterException ex) {
        return CommonResponse.withMessage(ex.getParameterName() + " 이 존재하지 않습니다");
    }
}
