package controllers;

import api.CreateReceiptRequest;
import dao.ReceiptDao;
import org.junit.Test;
import static org.junit.Assert.*;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ReceiptControllerTest {
    @Test
    public void validReceiptInsertWorks(){
        ReceiptDao receiptDaoMock = mock(ReceiptDao.class);
        when(receiptDaoMock.insert(any(), any())).thenReturn(3);
        CreateReceiptRequest createReceiptRequestMock = mock(CreateReceiptRequest.class);

        ReceiptController receiptController = new ReceiptController(receiptDaoMock);
        assertTrue(receiptController.createReceipt(createReceiptRequestMock) == 3);
    }
}
