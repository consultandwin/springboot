package com.example.customermicroservice.exception;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CustomerNotFoundException extends Exception {


    private int errorCode;
    private String errorMessage;

    public CustomerNotFoundException(String errorMessage) {
        this.errorMessage=errorMessage;
    }
}
