package com.api.aluguelcarro.util;

import com.api.aluguelcarro.utils.DateUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.text.ParseException;

public class DateUtilTest {

    @Test
    public void getCurrentDateReturnsCorrectDateFormat() {
        String currentDate = DateUtil.getCurrentDate();
        Assertions.assertTrue(currentDate.matches("\\d{2}/\\d{2}/\\d{4}"), "getCurrentDate should return a date in the format dd/MM/yyyy");
    }

    @Test
    public void stringDateToTimestampConvertsDateCorrectly() throws ParseException {
        Timestamp timestamp = DateUtil.stringDateToTimestamp("2022-03-12 14:23:00");
        Assertions.assertEquals("12/03/2022", DateUtil.timestampToString(timestamp), "stringDateToTimestamp should convert a date string to a timestamp object");
    }

    @Test
    public void timestampToStringReturnsCorrectDateFormat() throws ParseException {
        Timestamp timestamp = DateUtil.stringDateToTimestamp("2022-03-12 14:23:00");
        String dateString = DateUtil.timestampToString(timestamp);
        Assertions.assertTrue(dateString.matches("\\d{2}/\\d{2}/\\d{4}"), "timestampToString should return a date in the format dd/MM/yyyy");
    }
}
