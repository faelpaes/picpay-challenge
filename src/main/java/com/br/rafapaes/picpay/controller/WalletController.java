package com.br.rafapaes.picpay.controller;

import com.br.rafapaes.picpay.controller.dto.CreateWalletDto;
import com.br.rafapaes.picpay.entity.Wallet;
import com.br.rafapaes.picpay.service.WalletService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletController {

    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping("/wallets")
    public ResponseEntity<Wallet> createWallet(@RequestBody CreateWalletDto walletDto) {
        var wallet = walletService.createWallet(walletDto);
        return ResponseEntity.ok(wallet);
    }
}
