package com.common.common.dto;


public class NotificationRequest {
    private Long userId;
    private Long etudiantId;
    private String titre;
    private String message;
    public NotificationRequest() {
    }
    public NotificationRequest(
            Long userId,
            Long etudiantId,
            String titre,
            String message) {

        this.userId = userId;
        this.etudiantId = etudiantId;
        this.titre = titre;
        this.message = message;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getEtudiantId() {
        return etudiantId;
    }

    public void setEtudiantId(Long etudiantId) {
        this.etudiantId = etudiantId;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}