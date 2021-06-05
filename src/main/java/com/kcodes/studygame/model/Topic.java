package com.kcodes.studygame.model;

public enum Topic {

      COREJAVA("COREJAVA"),
              JAVASCRIPT("JAVASCRIPT"),
              SPRING("SPRING"),
              MSA("MSA"),
              REACT("REACT"),
              AWS("AWS"),
              DEVOPS("DEVOPS"),
              SQL("SQL"),
              HIBERNATE("HIBERNATE"),
              ANGULAR("ANGULAR"),
              OOP("OOP"),
              REST("REST");

    public final String label;

    private Topic(String label) {
        this.label = label;
    }
}
