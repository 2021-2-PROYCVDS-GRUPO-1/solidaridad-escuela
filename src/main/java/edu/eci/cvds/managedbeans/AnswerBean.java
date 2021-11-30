package edu.eci.cvds.managedbeans;

import edu.eci.cvds.entities.Answer;
import edu.eci.cvds.entities.Need;
import edu.eci.cvds.services.AnswerServices;
import edu.eci.cvds.services.NeedServices;
import edu.eci.cvds.services.OfferServices;
import edu.eci.cvds.services.ServicesException;
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

    @Inject
    private NeedServices needServices;

    private int id;
    private int idOffer;
    private int idNeeds;
    private String name;
    private String comments;
    private String nameOffer;
    private String nameNeed;
    private String nameOfferORNeed;
    private Date dateCreate;
    private List<String> statusList;
    private List<Answer> allAnswer;
    private Collection<String> listOffer;
    private Collection<String> listNeeds;
    private HashMap<Integer, String> listIdOffer;
    private HashMap<Integer, String> listIdNeeds;

    @PostConstruct
    public void init() {
        System.out.println("edu.eci.cvds.managedbeans.AnswerBean.init()");

        this.generateServices();
        this.generateLists();
    }

    public void createAnswer() {
        System.out.println("edu.eci.cvds.managedbeans.AnswerBean.createAnswer()");

        try{
            if((nameOffer.equals("")) && !(nameNeed.equals(""))){
                for(Integer date : listIdNeeds.keySet()) {
                    if (listIdNeeds.get(date).equals(nameNeed)) {
                        answerServices.addAnswerNeeds(name, comments, date);
                    }
                }
            } else if(!(nameOffer.equals("")) && (nameNeed.equals(""))){
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

    public void generateServices(){
        System.out.println("edu.eci.cvds.managedbeans.AnswerBean.generateServices()");

        answerServices = getInjector().getInstance(AnswerServices.class);
        offerServices = getInjector().getInstance(OfferServices.class);
        needServices = getInjector().getInstance(NeedServices.class);
    }

    public void generateLists(){
        System.out.println("edu.eci.cvds.managedbeans.AnswerBean.generateLists()");

        statusList = new ArrayList<>();
        listIdOffer = offerServices.getOffers();
        listOffer = listIdOffer.values();

        try {
            listIdNeeds = needServices.getNeeds();
        } catch (ServicesException e) {
            e.printStackTrace();
        }

        try {
            this.allAnswer = answerServices.getAnsOfferNeed();
        } catch (ServicesException e) {
            e.printStackTrace();
        }

        listNeeds = listIdNeeds.values();

        try {
            for(DatabaseStatus status : DatabaseStatus.values()){
                statusList.add(status.toString());
            }
        } catch (Exception exception) {
            exception.printStackTrace();
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

    public List<Answer> getAllAnswer() {
        return allAnswer;
    }

    public void setAllAnswer(List<Answer> allAnswer) {
        this.allAnswer = allAnswer;
    }

    public int getIdNeeds() {
        return idNeeds;
    }

    public void setIdNeeds(int idNeeds) {
        this.idNeeds = idNeeds;
    }

    public String getNameOfferORNeed() {
        return nameOfferORNeed;
    }

    public void setNameOfferORNeed(String nameOfferORNeed) {
        this.nameOfferORNeed = nameOfferORNeed;
    }
}
