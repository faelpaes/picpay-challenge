package com.br.rafapaes.picpay.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class WalletDataAlreadyExistsException extends PicPayException {
    private final String MESSAGE;

    public WalletDataAlreadyExistsException(String message) {
        this.MESSAGE = message;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        pb.setTitle("Wallet Data Already Exists");
        pb.setDetail(MESSAGE);
        return pb;
    }
}
