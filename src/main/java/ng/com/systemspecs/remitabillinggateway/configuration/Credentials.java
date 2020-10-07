package ng.com.systemspecs.remitabillinggateway.configuration;

import ng.com.systemspecs.remitabillinggateway.util.ApplicationConstant;
import ng.com.systemspecs.remitabillinggateway.util.EnvironmentType;
import org.springframework.util.StringUtils;

/**
 * All biller credentials needed are being setup by instantiating
 * the Credential Class and set properties in this class accordingly.
 *
 *
 * @author Ilesanmi Omoniyi
 *
 * @since 1.0.0
 */
public class Credentials {

	/**
	 * This field is a mandatory field for all method calls.
	 * Located at the Billing page of your Remita profile on www.remita.net.
	 *
	 */
	private String publicKey;

	/**
	 * This field is only mandatory for billNotification method calls.
	 * Located at the Billing page of your Remita profile on www.remita.net.
	 *
	 */
	private String secretKey;

	/**
	 * This field is an Optional field and will automatically be
	 * set to 200000 milliseconds if not supplied.
	 *
	 */
	private int readTimeOut;

	/**
	 * This field is an Optional field and will automatically be
	 * set to 200000 milliseconds if not supplied.
	 *
	 */
	private int connectionTimeOut;

	/**
	 * This field is only mandatory for billNotification method calls.
	 *
	 *
	 */
	private String transactionId;

    /**
     * This field is an Optional field and can only take enum type EnvironmentType.LIVE
     * or EnvironmentType.DEMO. It will automatically be set to "EnvironmentType.DEMO" if not supplied.
     *
     */
	private EnvironmentType environment;


	public int getReadTimeOut() {
		if(this.readTimeOut == 0 || StringUtils.isEmpty(this.readTimeOut)) {
			this.readTimeOut = 200000;
		}
		return readTimeOut;
	}

	public void setReadTimeOut(int readTimeOut) {
		this.readTimeOut = readTimeOut;
	}

	public int getConnectionTimeOut() {
		if(this.connectionTimeOut == 0 || StringUtils.isEmpty(this.connectionTimeOut)) {
			this.connectionTimeOut = 200000;
		}
		return connectionTimeOut;
	}

	public void setConnectionTimeOut(int connectionTimeOut) {
		this.connectionTimeOut = connectionTimeOut;
	}

	public EnvironmentType getEnvironment() {
		if(this.environment == null || StringUtils.isEmpty(this.environment)) {
			this.environment = EnvironmentType.DEMO;
		}
		return environment;
	}

	public void setEnvironment(EnvironmentType environment) {
		this.environment = environment;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	@Override
	public String toString() {
		return "Credentials{" +
				"publicKey='" + publicKey + '\'' +
				", secretKey='" + secretKey + '\'' +
				", readTimeOut=" + readTimeOut +
				", connectionTimeOut=" + connectionTimeOut +
				", transactionId='" + transactionId + '\'' +
				", environment='" + environment + '\'' +
				'}';
	}
}
