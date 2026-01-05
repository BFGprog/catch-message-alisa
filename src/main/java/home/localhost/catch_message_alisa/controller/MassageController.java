package home.localhost.catch_message_alisa.controller;

//import home.localhost.catch_message_alisa.model.request.YandexRequest;
import home.localhost.catch_message_alisa.service.interf.MassageService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("massage/")
public class MassageController {
//https://sixty-pianos-relate.loca.lt
//https://myalisa.loca.lt
//clo.exe publish http 8080
//clo publish http 9000

    Logger logger = LoggerFactory.getLogger(MassageController.class);
    private final MassageService massageService;

    public MassageController(MassageService massageService) {
        this.massageService = massageService;
    }

    @GetMapping("/{mas}")
    public String insMas(@PathVariable String mas) {
        logger.info("Get map insMas {}", mas);
        return "yep. it's Get.3";
    }

    @PostMapping("/**")
    public /*ResponseEntity<String>*/String handleAllPost(
            @RequestBody(required = false) String body,
            @RequestHeader Map<String, String> headers,
            HttpServletRequest request) {
        logger.info("Get handleAllPost ---");
        String uri = request.getRequestURI();

        System.out.println("URI: " + uri);
        System.out.println("Headers: " + headers);
        System.out.println("Body: " + body);
        return "Привет! Я ваш помощник. Чем могу помочь?";
    }

    @PostMapping
    public Map<String, Object> handleAliceRequest(@RequestBody Map<String, Object> request) {
        return massageService.GetMassage(request);
    }


}
/*

2025-12-03T00:11:12.929+03:00  INFO 9320 --- [catch-message-alisa] [nio-9000-exec-1] h.l.c.controller.MassageController       : Get handleAllPost ---
URI: /massage/
Headers: {host=proficiently-appeasing-firebrat.cloudpub.ru, user-agent=Mozilla/5.0 (compatible; YandexDialogs/1.0; +http://yandex.com/bots), content-length=828, accept=application/json, accept-encoding=gzip, x-gzip, deflate, br, connection=keep-alive, content-type=application/json, request-timeout=4600000, x-forwarded-for=5.255.253.48, x-forwarded-port=443, x-forwarded-host=proficiently-appeasing-firebrat.cloudpub.ru, x-forwarded-proto=https, x-real-ip=5.255.253.48, x-real-port=41632}
Body:
{"meta":
    {"locale":"ru-RU","timezone":"UTC","client_id":"ru.yandex.searchplugin/7.16 (none none; android 4.4.2)"
        ,"interfaces":{"screen":{},"payments":{},"account_linking":{}
     }
     }
,"session":{"message_id":0,"session_id":"0320f656-6fcc-48c8-972f-f3e48ada7888","skill_id":"32fee234-3272-4506-ab10-0929ffb66f69"
,"user":{"user_id":"C199B3EFB28E47EC24B77B96EA5131F7C0EF584CC04B2072C98AA7B4362808E5"}
,"application":{"application_id":"63C0B4C8CE01CD5F6BF63E1E2980257E2754887289E94487B02F462C84AA92EE"}
,"user_id":"63C0B4C8CE01CD5F6BF63E1E2980257E2754887289E94487B02F462C84AA92EE","new":true}
,"request":{"command":"132","original_utterance":"132"
,"nlu":{"tokens":["132"]
,"entities":[{"type":"YANDEX.NUMBER","tokens":{"start":0,"end":1}
,"value":132}]
,"intents":{}},"markup":{"dangerous_context":false}
,"type":"SimpleUtterance"}
,"version":"1.0"}

*/
