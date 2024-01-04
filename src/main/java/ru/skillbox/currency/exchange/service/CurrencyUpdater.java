package ru.skillbox.currency.exchange.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
@RequiredArgsConstructor
@Slf4j
public class CurrencyUpdater {
    private final CurrencyService currencyService;

    @Scheduled(cron = "${scheduler.update-interval}")
    private void updateCurrencies() {

        currencyService.updateAllCurrencies();
        log.info("All currencies have been updated");
    }
}
