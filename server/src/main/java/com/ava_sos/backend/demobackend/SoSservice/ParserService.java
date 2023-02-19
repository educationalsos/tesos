package com.ava_sos.backend.demobackend.SoSservice;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.ava_sos.backend.demobackend.SoSdomain.Behavior;
import com.ava_sos.backend.demobackend.SoSdomain.ComunicationalCapability;
import com.ava_sos.backend.demobackend.SoSdomain.Constituent;
import com.ava_sos.backend.demobackend.SoSdomain.Mission;
import com.ava_sos.backend.demobackend.SoSdomain.Services;
import com.ava_sos.backend.demobackend.SoSdomain.Sos;

@Service
@Scope("singleton")
public class ParserService {

    @Autowired
    private BehaviorService behavior_service;
    @Autowired
    private MissionService mission_service;
    @Autowired
    private ConstituentService const_service;
    @Autowired
    private ServicesService serv_service;
    @Autowired
    private ComunicationalCapabilityService capability_service;

    public void parseMissionModel(Sos sos) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            File file = new File(sos.getMkaos_model());
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();

            NodeList elements = doc.getElementsByTagName("consistsOf");
            NodeList links = doc.getElementsByTagName("linkedBy");

            List<Mission> missions = new ArrayList<Mission>();
            for (int i = 0; i < elements.getLength(); i++) {
                Node node = elements.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    switch (element.getAttribute("xsi:type")) {
                        case "dsl.mKAOS:Mission":
                            missions.add(new Mission(element.getAttribute("name"), sos, false));
                            break;
                        case "dsl.mKAOS:EmergentBehavior":
                            Behavior behavior = new Behavior(element.getAttribute("name"), sos);
                            behavior_service.save(behavior);
                            List<ComunicationalCapability> capabilities = new ArrayList<ComunicationalCapability>();
                            for (int j = 0; j < links.getLength(); j++) {
                                Node link_node = links.item(j);
                                if (node.getNodeType() == Node.ELEMENT_NODE) {
                                    Element link = (Element) link_node;
                                    if ((link.getAttribute("xsi:type").equals("dsl.mKAOS:EmergeLink"))
                                            && (link.getAttribute("behavior").contains(Integer.toString(i)))) {
                                        String[] split = link.getAttribute("capability").split("[.]");
                                        int index = Integer
                                                .parseInt(split[split.length - 1]);
                                        capabilities
                                                .add(new ComunicationalCapability(
                                                        elements.item(index).getAttributes()
                                                                .getNamedItem("name").getTextContent(),
                                                        behavior, false));

                                    }
                                }
                            }
                            capability_service.saveAll(capabilities);
                        default:
                            break;
                    }
                }

            }
            mission_service.saveAll(missions);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    public void parseConstituentModel(String path, Sos sos) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder db = dbf.newDocumentBuilder();

            File file = new File(path);
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();

            NodeList elements = doc.getElementsByTagName("consistsOf");
            Constituent constituent = new Constituent(elements.item(0).getAttributes()
                    .getNamedItem("name").getTextContent(), path, sos);
            const_service.save(constituent);
            List<Services> servs = new ArrayList<Services>();
            for (int i = 1; i < elements.getLength(); i++) {
                Node node = elements.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    switch (element.getAttribute("xsi:type")) {
                        case "dsl.mKAOS:OperationalCapability":
                            servs.add(new Services(constituent, element.getAttribute("name"), false));
                        default:
                            break;
                    }
                }

            }
            serv_service.saveAll(servs);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
