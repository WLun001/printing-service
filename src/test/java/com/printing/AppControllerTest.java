//package com.printing;
//
//import com.printing.domain.AppController;
//import com.printing.domain.Order;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InOrder;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.runners.MockitoJUnitRunner;
//
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//
//@RunWith(MockitoJUnitRunner.class)
//public class AppControllerTest {
//
//    @InjectMocks
//    private
//    AppController ac = new AppController();
//    @Mock
//    private
//    OrderList od;
//
//    @Test
//    public void testAddOrderInvokedCount() {
//        Order order = new Order(true, true);
//        ac.addOrder(order);
//        ac.addOrder(order);
//        verify(od, times(2)).addOrder(order);
//    }
//
//    @Test
//    public void testAddOrderInvokedSequence() {
//        Order order1 = new Order(true, true);
//        Order order2 = new Order(false, false);
//        ac.addOrder(order1);
//        ac.addOrder(order2);
//        InOrder inOrder = Mockito.inOrder(od);
//        inOrder.verify(od).addOrder(order1);
//        inOrder.verify(od).addOrder(order2);
//
//    }
//
//    @Test
//    public void testGetOrderList() {
//        ac.addOrder(new Order(true, false));
//        int quantity = ac.getNumberOfOrders();
//        verify(od, times(1)).getNumberOfOrders();
//    }
//
//    @Test
//    public void testGetNumberOfOrders() {
//        for (int i = 0; i < 10; i++) {
//            ac.addOrder(new Order(true, true));
//        }
//        int numOfOrders = ac.getNumberOfOrders();
//        verify(od, times(1)).getNumberOfOrders();
//    }
//
//    @Test
//    public void testSubmitOrder() {
//        ac.addOrder(new Order(true, true));
//        ac.submitOrder();
//        ac.submitOrder();
//        verify(od, times(2)).submitOrder();
//    }
//
//    @Test
//    public void testGetTotalCharge() {
//        ac.addOrder(new Order(true, true));
//        ac.submitOrder();
//        ac.getTotalCharge();
//        verify(od, times(1)).getTotalCharge();
//    }
//}
