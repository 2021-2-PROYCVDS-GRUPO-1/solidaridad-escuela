package edu.eci.cvds.managedbeans;

import edu.eci.cvds.entities.Offer;
import edu.eci.cvds.services.AnswerServices;
import edu.eci.cvds.services.NeedServices;
import edu.eci.cvds.services.OfferServices;
import edu.eci.cvds.utils.DatabaseStatus;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import java.util.*;

@ManagedBean(name = "answerBean")
@ApplicationScoped
public class AnswerBean extends BasePageBean{
    @Inject
    private AnswerServices answerServices;

    @Inject
    private OfferServices offerServices;

    /*@Inject
    private NeedServices needServices;*/

    private int id;
    private String name;
    private String comments;
    private Date dateCreate;
    private String nameOffer;
    private String nameNeed;
    private int idOffer;
    private int idNeeds;
    private List<String> statusList;
    private Collection<String> listOffer;
    private HashMap<Integer, String> listIdOffer;
    private Collection<String> listNeeds;
    private HashMap<Integer, String> listIdNeeds;

    @PostConstruct
    public void init(){
        statusList = new ArrayList<>();

        answerServices = getInjector().getInstance(AnswerServices.class);
        offerServices = getInjector().getInstance(OfferServices.class);

        listIdOffer = offerServices.getOffers();
        listOffer = listIdOffer.values();
        /*listIdNeeds = needServices.getNeeds();
        listNeeds = listIdNeeds.values();*/
        listNeeds = new ArrayList<>();

        try{
            for(DatabaseStatus status : DatabaseStatus.values()){
                System.out.println(status.toString());
                statusList.add(status.toString());
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void createAnswer() {
        try{
            if((nameOffer == "") && (nameNeed != "")){
                for(Integer date : listIdNeeds.keySet()) {
                    if (listIdNeeds.get(date).equals(nameNeed)) {
                        answerServices.addAnswerOffer(name, comments, date);
                    }
                }
            } else if((nameOffer != "") && (nameNeed == "")){
                for(Integer date : listIdOffer.keySet()) {
                    if (listIdOffer.get(date).equals(nameOffer)) {
                        answerServices.addAnswerOffer(name, comments, date);
                    }
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public AnswerServices getAnswerServices() {
        return answerServices;
    }

    public void setAnswerServices(AnswerServices answerServices) {
        this.answerServices = answerServices;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public int getIdOffer() {
        return idOffer;
    }

    public void setIdOffer(int idOffer) {
        this.idOffer = idOffer;
    }

    public OfferServices getOfferServices() {
        return offerServices;
    }

    public void setOfferServices(OfferServices offerServices) {
        this.offerServices = offerServices;
    }

    public List<String> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<String> statusList) {
        this.statusList = statusList;
    }

    public Collection<String> getListOffer() {
        return listOffer;
    }

    public void setListOffer(Collection<String> listOffer) {
        this.listOffer = listOffer;
    }

    public HashMap<Integer, String> getListIdOffer() {
        return listIdOffer;
    }

    public void setListIdOffer(HashMap<Integer, String> listIdOffer) {
        this.listIdOffer = listIdOffer;
    }

    public Collection<String> getListNeeds() {
        return listNeeds;
    }

    public void setListNeeds(Collection<String> listNeeds) {
        this.listNeeds = listNeeds;
    }

    public HashMap<Integer, String> getListIdNeeds() {
        return listIdNeeds;
    }

    public void setListIdNeeds(HashMap<Integer, String> listIdNeeds) {
        this.listIdNeeds = listIdNeeds;
    }

    public String getNameOffer() {
        return nameOffer;
    }

    public void setNameOffer(String nameOffer) {
        this.nameOffer = nameOffer;
    }

    public String getNameNeed() {
        return nameNeed;
    }

    public void setNameNeed(String nameNeed) {
        this.nameNeed = nameNeed;
    }

    public int getIdNeeds() {
        return idNeeds;
    }

    public void setIdNeeds(int idNeeds) {
        this.idNeeds = idNeeds;
    }
}
