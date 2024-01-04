package ru.skillbox.currency.exchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skillbox.currency.exchange.entity.Currency;

import java.util.Optional;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    Optional<Currency> findByIsoNumCode(Long isoNumCode);
}
