package ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;

public class LoadBalancerConfiguration {

  @Autowired
  IClientConfig ribbonClientConfig;

  @Bean
  public IPing ribbonPing(IClientConfig config) {
    return new PingUrl();
  }

  @Bean
  public IRule ribbonRule(IClientConfig config) {
	  return  new com.netflix.loadbalancer.RoundRobinRule();
  }

}