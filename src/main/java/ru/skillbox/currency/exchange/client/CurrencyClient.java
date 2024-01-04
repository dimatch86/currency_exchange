package ru.skillbox.currency.exchange.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.skillbox.currency.exchange.dto.XmlCurrencyList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class CurrencyClient {

    @Value("${app.currency.url}")
    private String url;
    private final OkHttpClient okHttpClient;

    public XmlCurrencyList getXmlCurrencyList() {
        XmlCurrencyList xmlCurrencyList = new XmlCurrencyList();
        Request request = new Request.Builder().url(url).build();

        try (Response response = okHttpClient.newCall(request).execute()) {

            JAXBContext jaxbContext = JAXBContext.newInstance(XmlCurrencyList.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            xmlCurrencyList = (XmlCurrencyList) jaxbUnmarshaller.unmarshal(new StringReader(Objects.requireNonNull(response.body()).string()));

        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
        return xmlCurrencyList;
    }
}
