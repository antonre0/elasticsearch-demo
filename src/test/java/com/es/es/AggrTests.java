package com.es.es;

import com.es.es.mapper.BShopMapper;
import com.es.es.mapper.StatisticsOrderMapper;
import com.es.es.po.*;
import com.es.es.repository.OrderRepository;
import com.es.es.repository.SalaryRepository;
import com.es.es.repository.ShopRepository;
import org.assertj.core.util.Lists;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.histogram.DateHistogramAggregationBuilder;
import org.elasticsearch.search.aggregations.bucket.histogram.DateHistogramInterval;
import org.elasticsearch.search.aggregations.bucket.histogram.InternalDateHistogram;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.sum.Sum;
import org.elasticsearch.search.aggregations.metrics.tophits.TopHits;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AggrTests {


    @Autowired
    private SalaryRepository salaryRepository;

    @Test
    public void funsalary() throws ParseException {
        ArrayList<Salary> salaries = Lists.newArrayList(
                Salary.builder()
                        .id(1)
                        .city("北京")
                        .year("2019")
                        .month("6")
                        .level(Character.valueOf('A').toString())
                        .name("王二")
                        .text("11133vvv")
                        .price3(100).dateTime(new SimpleDateFormat("yyyyMMdd").parse("20190601")).price4(100)
                        .build(),
                Salary.builder()
                        .id(2)
                        .city("北京")
                        .year("2019")
                        .month("5")
                        .level(Character.valueOf('A').toString())
                        .name("王二")
                        .text("11133vvv")
                        .price3(100).dateTime(new SimpleDateFormat("yyyyMMdd").parse("20190501")).price4(100)
                        .build(),
                Salary.builder()
                        .id(3)
                        .city("上海")
                        .year("2019")
                        .month("5")
                        .level(Character.valueOf('A').toString())
                        .name("饿二")
                        .text("11133vvv")
                        .price3(100).dateTime(new SimpleDateFormat("yyyyMMdd").parse("20190501")).price4(100)
                        .build(),
                Salary.builder()
                        .id(4)
                        .city("上海")
                        .year("2019")
                        .month("6")
                        .level(Character.valueOf('A').toString())
                        .price("5000.00")
                        .name("饿二")
                        .text("11133vvv")
                        .price3(100)
                        .price4(100)
                        .dateTime(new SimpleDateFormat("yyyyMMdd").parse("20190601"))
                        .build(),
        Salary.builder()
                .id(5)
                .city("上海")
                .year("2019")
                .month("6")
                .level(Character.valueOf('A').toString())
                .price("5000.00")
                .name("饿二")
                .text("11133vvv")
                .price3(100)
                .price4(100)
                .dateTime(new SimpleDateFormat("yyyyMMdd").parse("20191201"))
                .build(),        Salary.builder()
                .id(6)
                .city("上海")
                .year("2019")
                .month("6")
                .level(Character.valueOf('A').toString())
                .price("5000.00")
                .name("饿二")
                .text("11133vvv")
                .price3(100)
                .price4(100)
                .dateTime(new SimpleDateFormat("yyyyMMdd").parse("20190601"))
                .build(),        Salary.builder()
                .id(7)
                .city("上海")
                .year("2019")
                .month("6")
                .level(Character.valueOf('A').toString())
                .price("5000.00")
                .name("饿二")
                .text("11133vvv")
                .price3(100)
                .price4(100)
                .dateTime(new SimpleDateFormat("yyyyMMdd").parse("20190601"))
                .build(),        Salary.builder()
                .id(8)
                .city("上海")
                .year("2019")
                .month("6")
                .level(Character.valueOf('A').toString())
                .price("5000.00")
                .name("饿二")
                .text("11133vvv")
                .price3(100)
                .price4(100)
                .dateTime(new SimpleDateFormat("yyyyMMdd").parse("20190401"))
                .build(),        Salary.builder()
                .id(9)
                .city("上海")
                .year("2019")
                .month("6")
                .level(Character.valueOf('A').toString())
                .price("5000.00")
                .name("饿二")
                .text("11133vvv")
                .price3(100)
                .price4(100)
                .dateTime(new SimpleDateFormat("yyyyMMdd").parse("20190301"))
                .build(),        Salary.builder()
                .id(10)
                .city("上海")
                .year("2019")
                .month("6")
                .level(Character.valueOf('A').toString())
                .price("5000.00")
                .name("饿二")
                .text("11133vvv")
                .price3(100)
                .price4(100)
                .dateTime(new SimpleDateFormat("yyyyMMdd").parse("20190201"))
                .build(),        Salary.builder()
                .id(11)
                .city("上海")
                .year("2019")
                .month("6")
                .level(Character.valueOf('A').toString())
                .price("5000.00")
                .name("饿二")
                .text("11133vvv")
                .price3(100)
                .price4(100)
                .dateTime(new SimpleDateFormat("yyyyMMdd").parse("20190101"))
                .build());

        salaryRepository.saveAll(salaries);
    }

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    @Test
    public void funSearch() throws ParseException {
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        QueryBuilder query = QueryBuilders.boolQuery()
                .must(QueryBuilders.rangeQuery("dateTime").gte(new SimpleDateFormat("yyyyMMdd").parse("20190501").getTime())
                        .lte(new SimpleDateFormat("yyyyMMdd").parse("20190601").getTime()))
                ;

        queryBuilder.withQuery(query);

//        ((BoolQueryBuilder) query).must(QueryBuilders.matchQuery("name","王二"));

        //设置聚合字段
//        queryBuilder.addAggregation(AggregationBuilders.terms("cityId").field("cityId").size(1000)
//                .subAggregation(AggregationBuilders.terms("teamId").field("teamId"))//设置组内统计
//                .subAggregation(AggregationBuilders.topHits("priceSum2").size(1))
//        );
//分页
        queryBuilder.withPageable(PageRequest.of(2, 5));
//排序
//        queryBuilder.withSort(SortBuilders.fieldSort("month").order(SortOrder.DESC));

        AggregatedPage<Salary> result = elasticsearchTemplate.queryForPage(queryBuilder.build(), Salary.class);

        //解析聚合
        Aggregations aggr = result.getAggregations();

        //获取指定名称的聚合
        StringTerms terms = aggr.get("group_month");

        //获取桶
        List<StringTerms.Bucket> buckets = terms.getBuckets();

        for (StringTerms.Bucket bucket : buckets) {
            String keyAsString = bucket.getKeyAsString();
            Sum priceSum = bucket.getAggregations().get("priceSum");
            System.out.println(priceSum.getValue());
            long docCount = bucket.getDocCount();
            System.out.println("key:"+keyAsString+" Count:"+docCount);
        }
    }


    /**
     * 日期 分组
     * @throws ParseException
     */
    @Test
    public void aggrDate() throws ParseException {
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();

        DateHistogramAggregationBuilder dateHistogramName = AggregationBuilders
                .dateHistogram("dateHistogramName")
                .field("dateTime")                                  //分组字段
                .dateHistogramInterval(DateHistogramInterval.MONTH) //按什么时间分组
                .format("yyyy-MM-dd");                              //格式化

        //设置子分组 统计
        dateHistogramName.subAggregation(AggregationBuilders.sum("sumName").field("price3"));
        queryBuilder.addAggregation(dateHistogramName);

        AggregatedPage<Salary> result = elasticsearchTemplate.queryForPage(queryBuilder.build(), Salary.class);

        //解析聚合
        Aggregations aggr = result.getAggregations();

        //获取指定名称的聚合
        InternalDateHistogram terms = aggr.get("dateHistogramName");

        //获取桶
        List<InternalDateHistogram.Bucket> buckets = terms.getBuckets();

        for (InternalDateHistogram.Bucket bucket : buckets) {
            String keyAsString = bucket.getKeyAsString(); //结果会比实际时间少一个月
            Sum priceSum = bucket.getAggregations().get("sumName"); //获取统计结果
            System.out.println(priceSum.getValue());
            long docCount = bucket.getDocCount();
            System.out.println("key:"+keyAsString+" Count:"+docCount);
        }
    }


    /**
     * 获取分组后对象
     * @throws ParseException
     */
    @Test
    public void aggrTopHits() throws ParseException {
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();

        TermsAggregationBuilder termsAggregationBuilder = AggregationBuilders
                .terms("cityId").field("cityId").size(1000)
                .subAggregation(
                        AggregationBuilders.topHits("topHits")
//                                .fetchSource(new String[]{ "cityName"},null)//设置需要 的字段
                                .size(1)//设需要同组的 数量
                );

        queryBuilder.addAggregation(termsAggregationBuilder);

        AggregatedPage<Salary> result = elasticsearchTemplate.queryForPage(queryBuilder.build(), Salary.class);

        //解析聚合
        Aggregations aggr = result.getAggregations();

        //获取指定名称的聚合
        StringTerms terms = aggr.get("cityId");

        //获取桶
        List<StringTerms.Bucket> buckets = terms.getBuckets();

        for (StringTerms.Bucket bucket : buckets) {
            String keyAsString = bucket.getKeyAsString(); //分组 key

            TopHits topHits = bucket.getAggregations().get("topHits");
            SearchHit[] hits = topHits.getHits().getHits();
            SearchHit hit = hits[0];
            Map<String, Object> sourceAsMap = hit.getSourceAsMap(); //最终对象
        }
    }



}
