package com.sample.integration;

import com.sample.ElasticsearchApplication;
import com.sample.db.elasticsearch.index.IBookingESMapper;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.admin.indices.flush.FlushRequest;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { ElasticsearchApplication.class })
@Log4j2
public class SampleBookingsIndexIT {

    @Autowired
    private IBookingESMapper bookingESMapper;
    @Autowired
    Client elasticSearchClient;

    @Test
    public void bookingsTest()throws Exception{
        BulkRequestBuilder bulkRequestBuilder = elasticSearchClient.prepareBulk();

        this.bookingESMapper.map();
        for (int i=1; i<=3; i++) {
            LocalDate date = LocalDate.now().minusDays(new Random().nextInt(10));
            XContentBuilder xb = XContentFactory.jsonBuilder().startObject();
            xb.field("fec_creacion", date);
            xb.field("seq_reserva", new Random().nextInt(9999999));
            xb.field("seq_hotel", 183473);
            xb.field("cod_destino", "MIL");
            xb.field("seq_zona_ge", 16);
            xb.field("cod_pais", "IT");
            xb.field("seq_ttoo", 81279);
            xb.field("cod_canal_venta", "B2");
            bulkRequestBuilder.add(elasticSearchClient.prepareIndex("bookings", "booking", "1-" + i).setSource(xb));
        }

        for (int i=1; i<=5; i++) {
            LocalDate date = LocalDate.now().minusDays(new Random().nextInt(10));
            XContentBuilder xb = XContentFactory.jsonBuilder().startObject();
            xb.field("fec_creacion", date);
            xb.field("seq_reserva", new Random().nextInt(9999999));
            xb.field("seq_hotel", 12744);
            xb.field("cod_destino", "LVS");
            xb.field("seq_zona_ge", 8);
            xb.field("cod_pais", "US");
            xb.field("seq_ttoo", 42404);
            xb.field("cod_canal_venta", "B2");
            bulkRequestBuilder.add(elasticSearchClient.prepareIndex("bookings", "booking", "2-" + i).setSource(xb));
        }

        for (int i=1; i<=8; i++) {
            LocalDate date = LocalDate.now().minusDays(new Random().nextInt(10));
            XContentBuilder xb = XContentFactory.jsonBuilder().startObject();
            xb.field("fec_creacion", date);
            xb.field("seq_reserva", new Random().nextInt(9999999));
            xb.field("seq_hotel", 2643);
            xb.field("cod_destino", "PMI");
            xb.field("seq_zona_ge", 90);
            xb.field("cod_pais", "ES");
            xb.field("seq_ttoo", 40388);
            xb.field("cod_canal_venta", "B2");
            bulkRequestBuilder.add(elasticSearchClient.prepareIndex("bookings", "booking", "3-" + i).setSource(xb));
        }

        for (int i=1; i<=13; i++) {
            LocalDate date = LocalDate.now().minusDays(new Random().nextInt(10));
            XContentBuilder xb = XContentFactory.jsonBuilder().startObject();
            xb.field("fec_creacion", date);
            xb.field("seq_reserva", new Random().nextInt(9999999));
            xb.field("seq_hotel", 143592);
            xb.field("cod_destino", "NUE");
            xb.field("seq_zona_ge", 6);
            xb.field("cod_pais", "DE");
            xb.field("seq_ttoo", 6851);
            xb.field("cod_canal_venta", "B2");
            bulkRequestBuilder.add(elasticSearchClient.prepareIndex("bookings", "booking", "4-" + i).setSource(xb));
        }

        for (int i=1; i<=21; i++) {
            LocalDate date = LocalDate.now().plusDays(new Random().nextInt(10));
            XContentBuilder xb = XContentFactory.jsonBuilder().startObject();
            xb.field("fec_creacion", date);
            xb.field("seq_reserva", new Random().nextInt(9999999));
            xb.field("seq_hotel", 86478);
            xb.field("cod_destino", "PAR");
            xb.field("seq_zona_ge", 18);
            xb.field("cod_pais", "FR");
            xb.field("seq_ttoo", 91727);
            xb.field("cod_canal_venta", "B2");
            bulkRequestBuilder.add(elasticSearchClient.prepareIndex("bookings", "booking", "5-" + i).setSource(xb));
        }


        bulk(bulkRequestBuilder, "bookings");
    }



    protected void bulk(BulkRequestBuilder bulkRequestBuilder, String indexName) {
        BulkResponse bulkResponse = bulkRequestBuilder.execute().actionGet();
        if (!bulkResponse.hasFailures()) {
            elasticSearchClient.admin().indices().flush(new FlushRequest(indexName).force(true)).actionGet();
        } else {
            log.info("bulk failure!!!" + " bulk failure message: " + bulkResponse.buildFailureMessage());
        }
        bulkRequestBuilder = elasticSearchClient.prepareBulk();
    }
}
