package kr.co.tmax.arenademobe.validator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.MessageSource;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class ValidationResult {
    private List<FieldErrorDetail> errors;

    public static ValidationResult create(Errors errors, MessageSource messageSource, Locale locale) {
        List<FieldErrorDetail> details =
                errors.getFieldErrors()
                        .stream()
                        .map(error -> FieldErrorDetail.create(error, messageSource, locale))
                        .collect(Collectors.toList());
        return new ValidationResult(details);
    }

    @Setter
    @Getter
    @AllArgsConstructor
    public static class FieldErrorDetail {
        private String objectName;
        private String field;
        private String code;
        private String message;

        public static FieldErrorDetail create(FieldError fieldError, MessageSource messageSource, Locale locale) {
            return new FieldErrorDetail(
                    fieldError.getObjectName(),
                    fieldError.getField(),
                    fieldError.getCode(),
                    messageSource.getMessage(fieldError, locale));
        }

        @Override
        public String toString() {
            return message;
        }
    }
}
