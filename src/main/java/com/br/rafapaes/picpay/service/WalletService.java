package com.br.rafapaes.picpay.service;

import com.br.rafapaes.picpay.controller.dto.CreateWalletDto;
import com.br.rafapaes.picpay.entity.Wallet;
import com.br.rafapaes.picpay.exception.WalletDataAlreadyExistsException;
import com.br.rafapaes.picpay.repository.WalletRepository;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

     private final WalletRepository walletRepository;

     public WalletService(WalletRepository walletRepository) {
         this.walletRepository = walletRepository;
     }

     public Wallet createWallet(CreateWalletDto walletDto) {
         walletRepository.findByCpfCnpjOrEmail(walletDto.cpfCnpj(), walletDto.email())
                 .ifPresent(wallet -> {
                     throw new WalletDataAlreadyExistsException("CpfCnpj or email already exists");
                 });

         return walletRepository.save(walletDto.toWallet());
     }
}
