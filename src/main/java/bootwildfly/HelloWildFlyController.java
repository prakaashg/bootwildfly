package bootwildfly;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.dao.ModMonitorStatus;

@RestController
public class HelloWildFlyController {
	private ModMonitorStatus status = new ModMonitorStatus();
    
    @RequestMapping("hello")
    public Map<String, String> sayHello() throws Exception{
        return status.getLatestMonitorStatus();
    }
    
}