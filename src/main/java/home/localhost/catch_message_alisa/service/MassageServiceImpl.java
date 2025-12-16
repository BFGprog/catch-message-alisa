package home.localhost.catch_message_alisa.service;

import home.localhost.catch_message_alisa.service.interf.ItemService;
import home.localhost.catch_message_alisa.service.interf.MassageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MassageServiceImpl implements MassageService {

    private final ItemService itemService;
    public MassageServiceImpl(ItemService itemService) {
        this.itemService = itemService;
    }
    Logger logger = LoggerFactory.getLogger(MassageServiceImpl.class);

    @Override
    public Map<String, Object> GetMassage(Map<String, Object> request){
        logger.info("Get massage ");
        Map<String, Object> session = (Map<String, Object>) request.get("session");
        Map<String, Object> req = (Map<String, Object>) request.get("request");

        String command = req != null ? (String) req.get("command") : "";
        String item = itemService.extractItem(command);
        String answer = (session != null && Boolean.TRUE.equals(session.get("new"))) ? "Что добавить?" : item;



        Map<String, Object> response = new HashMap<>();
        response.put("text", answer);
        response.put("end_session", false);

        Map<String, Object> result = new HashMap<>();
        result.put("version", "1.0");
        result.put("session", session);
        result.put("response", response);
        return result;
    }
}
