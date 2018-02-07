 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.course6.eindopdracht6;

/**
 *
 * @author Thijs Weenink
 * @version 1.0
 * <br>Virus objects
 */
public class Virus implements Comparable {

    private String virusTaxID;
    private String virusName;
    private String virusLineage;
    private String refseqID;
    private String KEGGGenome;
    private String KEGGDisease;
    private String disease;
    private String hostTaxID;
    private String hostLineage;
    private String pmid;
    private String evidence;
    private Integer length;

    Virus() {

    }

    Virus(String[] tsvVirusses) {
        this.virusTaxID = tsvVirusses[0];
        this.virusName = tsvVirusses[1];
        this.virusLineage = tsvVirusses[2];
        this.refseqID = tsvVirusses[3];
        this.KEGGGenome = tsvVirusses[4];
        this.KEGGDisease = tsvVirusses[5];
        this.disease = tsvVirusses[6];
        this.hostTaxID = tsvVirusses[7];
        this.hostLineage = tsvVirusses[8];
        this.pmid = tsvVirusses[9];
        this.evidence = tsvVirusses[10];
        this.length = null;
    }

    Virus(String[] tsvVirusses, int length) {
        this.virusTaxID = tsvVirusses[0];
        this.virusName = tsvVirusses[1];
        this.virusLineage = tsvVirusses[2];
        this.refseqID = tsvVirusses[3];
        this.KEGGGenome = tsvVirusses[4];
        this.KEGGDisease = tsvVirusses[5];
        this.disease = tsvVirusses[6];
        this.hostTaxID = tsvVirusses[7];
        this.hostLineage = tsvVirusses[8];
        this.pmid = tsvVirusses[9];
        this.evidence = tsvVirusses[10];
        this.length = length;
    }

    Virus(String virusTaxID, String virusName, String virusLineage, String refseqID, String KEGGGenome, String KEGGDisease, String disease, String hostTaxID, String hostLineage, String pmid, String evidence) {
        this.virusTaxID = virusTaxID;
        this.virusName = virusName;
        this.virusLineage = virusLineage;
        this.refseqID = refseqID;
        this.KEGGGenome = KEGGGenome;
        this.KEGGDisease = KEGGDisease;
        this.disease = disease;
        this.hostTaxID = hostTaxID;
        this.hostLineage = hostLineage;
        this.pmid = pmid;
        this.evidence = evidence;
    }

    // Getters and Setters
    public String getVirusTaxID() {
        return virusTaxID;
    }

    public void setVirusTaxID(String virusTaxID) {
        this.virusTaxID = virusTaxID;
    }

    public String getVirusName() {
        return virusName;
    }

    public void setVirusName(String virusName) {
        this.virusName = virusName;
    }

    public String getVirusLineage() {
        return virusLineage;
    }

    public void setVirusLineage(String virusLineage) {
        this.virusLineage = virusLineage;
    }

    public String getRefseqID() {
        return refseqID;
    }

    public void setRefseqID(String refseqID) {
        this.refseqID = refseqID;
    }

    public String getKEGGGenome() {
        return KEGGGenome;
    }

    public void setKEGGGenome(String KEGGGenome) {
        this.KEGGGenome = KEGGGenome;
    }

    public String getKEGGDisease() {
        return KEGGDisease;
    }

    public void setKEGGDisease(String KEGGDisease) {
        this.KEGGDisease = KEGGDisease;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getHostTaxID() {
        return hostTaxID;
    }

    public void setHostTaxID(String hostTaxID) {
        this.hostTaxID = hostTaxID;
    }

    public String getHostLineage() {
        return hostLineage;
    }

    public void setHostLineage(String hostLineage) {
        this.hostLineage = hostLineage;
    }

    public String getPmid() {
        return pmid;
    }

    public void setPmid(String pmid) {
        this.pmid = pmid;
    }

    public String getEvidence() {
        return evidence;
    }

    public void setEvidence(String evidence) {
        this.evidence = evidence;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    // Couldn't be bothered to fix this anymore, so it's basically useless now
    @Override
    public int compareTo(Object o) {
        Virus v = (Virus) o;
        return this.hostTaxID.compareTo(v.hostTaxID);
    }
    
}
