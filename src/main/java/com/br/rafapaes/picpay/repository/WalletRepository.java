package com.br.rafapaes.picpay.repository;

import com.br.rafapaes.picpay.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
}
