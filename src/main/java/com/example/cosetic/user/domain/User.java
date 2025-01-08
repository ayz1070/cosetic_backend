package com.example.cosetic.user.domain;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * 사용자 도메인 엔티티 (JPA 매핑)
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private OffsetDateTime createdAt;

    @Column
    private String displayName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column
    private OffsetDateTime lastLoginAt;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_linked_providers", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "provider")
    private List<String> linkedProviders;

    @Column
    private int loyaltyPoints;

    @Column
    private boolean mandatoryConsents;

    @Column
    private String role;  // e.g. "user", "admin"

    @Column
    private String tier;  // e.g. "bronze", "silver"

    @Column
    private String uid;   // Firebase 등 외부 인증 UID

    @Column
    private int purchaseCount;

    @Column
    private long totalPurchaseAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public OffsetDateTime getLastLoginAt() {
        return lastLoginAt;
    }

    public void setLastLoginAt(OffsetDateTime lastLoginAt) {
        this.lastLoginAt = lastLoginAt;
    }

    public List<String> getLinkedProviders() {
        return linkedProviders;
    }

    public void setLinkedProviders(List<String> linkedProviders) {
        this.linkedProviders = linkedProviders;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public boolean isMandatoryConsents() {
        return mandatoryConsents;
    }

    public void setMandatoryConsents(boolean mandatoryConsents) {
        this.mandatoryConsents = mandatoryConsents;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }

    public void setPurchaseCount(int purchaseCount) {
        this.purchaseCount = purchaseCount;
    }

    public long getTotalPurchaseAmount() {
        return totalPurchaseAmount;
    }

    public void setTotalPurchaseAmount(long totalPurchaseAmount) {
        this.totalPurchaseAmount = totalPurchaseAmount;
    }


    public User() {

    }


    // 예: 편의 메서드 (포인트 적립, 구매 카운트 증가 등)
    public void addLoyaltyPoints(int amount) {
        this.loyaltyPoints += amount;
    }

    public void increasePurchaseCount(int purchasedAmount) {
        this.purchaseCount++;
        this.totalPurchaseAmount += purchasedAmount;
    }
}
