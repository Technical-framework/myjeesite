package com.thinkgem.jeesite.common.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.core.io.Resource;

/**
 * ClassName:RemoteConfig <br/>
 * Reason: TODO 读取remote配置文件信息. <br/>
 * Date: 2015年11月4日 下午2:35:23 <br/>
 * 
 * @author haoxi
 */
public class RemoteConfig implements FactoryBean<Object> {

	private static Logger logger = Logger.getLogger(RemoteConfig.class);

	private static Properties props = null;

	private Resource configLocation;

	public Resource getConfigLocation() {
		return configLocation;
	}

	public void setConfigLocation(Resource configLocation) {
		this.configLocation = configLocation;
	}

	public void init() throws Exception {
		if (this.configLocation == null) {
			throw new IllegalArgumentException("configLocation is required");
		}

		loadConfig(configLocation);
	}

	/**
	 * 清除加载
	 */
	public static void clearProps() {
		if (props != null) {
			props = null;
		}
	}

	/**
	 * 加载
	 * 
	 * @param configLocation
	 */
	public void loadConfig(Resource configLocation) {
		if (props == null) {
			props = new Properties();

			InputStream fistream = null;

			try {
				fistream = configLocation.getInputStream();
				props.load(fistream);
			} catch (Exception e) {
				logger.error(e.getMessage());
			} finally {
				if (fistream != null) {
					try {
						fistream.close();
					} catch (IOException e) {
						logger.error(e.getMessage());
					}
				}
			}

		}
	}

	/**
	 * 读取属性值
	 * 
	 * @since 2012-8-14
	 * @param key
	 *            string
	 * @return <br>
	 *         <b>author: nan.jiang</b> <br>
	 *         创建时间：2012-8-14 下午3:03:17
	 */
	public static String getString(String key) {
		return props.getProperty(key);
	}

	public Object getObject() throws Exception {
		return null;
	}

	public Class getObjectType() {
		return null;
	}

	public boolean isSingleton() {
		return false;
	}
}
