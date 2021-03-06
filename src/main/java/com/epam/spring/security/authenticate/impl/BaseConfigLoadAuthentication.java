package com.epam.spring.security.authenticate.impl;

import com.epam.loader.config.credentials.HttpCredentials;
import com.epam.loader.config.credentials.Krb5Credentials;
import com.epam.loader.config.credentials.SshCredentials;
import com.epam.spring.security.authenticate.BaseCredentialsToken;

public class BaseConfigLoadAuthentication extends BaseCredentialsToken {
  private HttpCredentials httpCredentials;
  private Krb5Credentials krb5Credentials;
  private SshCredentials sshCredentials;

  public BaseConfigLoadAuthentication( HttpCredentials httpCredentials, Krb5Credentials krb5Credentials,
                                       SshCredentials sshCredentials ) {
    this.httpCredentials = httpCredentials;
    this.krb5Credentials = krb5Credentials;
    this.sshCredentials = sshCredentials;
  }

  public HttpCredentials getHttpCredentials() {
    return httpCredentials;
  }

  public void setHttpCredentials( HttpCredentials httpCredentials ) {
    this.httpCredentials = httpCredentials;
  }

  public Krb5Credentials getKrb5Credentials() {
    return krb5Credentials;
  }

  public void setKrb5Credentials( Krb5Credentials krb5Credentials ) {
    this.krb5Credentials = krb5Credentials;
  }

  public SshCredentials getSshCredentials() {
    return sshCredentials;
  }

  public void setSshCredentials( SshCredentials sshCredentials ) {
    this.sshCredentials = sshCredentials;
  }
}
