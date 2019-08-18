package br.ufms.estagio.config.login;


public class UserCredentials {
    private String token;
    private String dn;
    private String role;
    public UserCredentials(){

    }
   public  UserCredentials(String token, String dn) {
        this.dn = dn;
        this.token = token;
        this.role = "ALUNO";
    }

    public boolean match(String dn) {
        return this.dn.equals(dn);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getDn() {
        return dn;
    }

    public void setDn(String dn) {
        this.dn = dn;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}