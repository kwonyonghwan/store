package keyosk;


import java.util.Optional;
import keyosk.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @Autowired StoreRepository storeRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPayed_Order(@Payload Payed payed){

        if(!payed.validate()) return;

        System.out.println("\n\n##### listener Order : " + payed.toJson() + "\n\n");
        
        //ORDER 받아서 저장 
        Store storeObj = new Store();

        storeObj.setOrderId(payed.getOrderId());
        storeObj.setOrderStatus(payed.getOrderStatus());

        if(payed.getOrderStatus() == "PAYED"){
            storeObj.setTotalPrice(payed.getTotalPrice());
        }

        System.out.println("\n\n##### SAVE STOREOBJ : " + storeObj.getOrderId() + "\n\n");

        storeRepository.save(storeObj);


    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPayCancelled_OrderCacell(@Payload PayCancelled payCancelled){

        if(!payCancelled.validate()) return;

        System.out.println("\n\n##### listener OrderCacell : " + payCancelled.toJson() + "\n\n");


        // Sample Logic //
        Store storeObj = new Store();

        Optional<Store> tempObj =  storeRepository.findById(payCancelled.getOrderId());

        if(tempObj.isPresent()){
           storeObj = tempObj.get();		
        }else{
         
            System.out.println( "no STORE data");
        } 

        storeObj.setOrderStatus("PAY CANCELLED");
        System.out.println( "storeObjstoreObj " + storeObj.toString());
        storeRepository.save(storeObj);
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}
