package listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TestQueueListener {
    @RabbitListener(queues = "testqueue01")
    public void testListener(String message){
        System.out.println("Nội dung được lấy từ queue01" + message);
    }
}
