/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArchiveOnlineServer;

import ArchiveProgram.Archiver;
import com.sun.jersey.api.client.ClientHandlerException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

/**
 *
 * @author minel
 */
public class Main {

    private static int portNumber = 8084;
    private static Server jettyServer;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            //Запускаем сервер Jetty и севрисы
            startJetty(portNumber);

            //Создаем объект архиватор
            Archiver archiver = new Archiver(portNumber, "zipator", 10, 10, Archiver.ServerType.DEPRESSOR);

            for (int i = 0; i < 2; i++) {
                archiver.addFile("1");
            }
            
            //Регистрируем его
            archiver.register();

            //Главный поток ожидает завершения Jetty
            jettyServer.join();

        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Запускает сервер Jetty на указаном порту
    private static void startJetty(int port) {

        jettyServer = new Server(port);

        ResourceConfig config = new ResourceConfig();
        config.packages("ArchiverServices");

        ServletHolder servlet = new ServletHolder(new ServletContainer(config));

        ServletContextHandler context = new ServletContextHandler(jettyServer, "/*");
        context.addServlet(servlet, "/*");

        try {
            jettyServer.start();
        }catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            jettyServer.destroy();
        }
        
    }
}