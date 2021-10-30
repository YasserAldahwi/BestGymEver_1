package com.company;

import java.time.LocalDate;

public class ClubMember {
    private String personalNumber;
    private String name;
    private LocalDate subscriptionDate;

    public ClubMember(String personalNumber, String name, LocalDate subscriptionDate) {
        this.personalNumber = personalNumber;
        this.name = name;
        this.subscriptionDate = subscriptionDate;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public String getName() {
        return name;
    }

    public LocalDate getSubscriptionDate() {
        return subscriptionDate;
    }

    @Override
    public String toString() {
        return "ClubMember{" +
                "personalNumber='" + personalNumber + '\'' +
                ", name='" + name + '\'' +
                ", subscriptionDate=" + subscriptionDate +
                '}';
    }
}
