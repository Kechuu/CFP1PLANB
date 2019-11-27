/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporte;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
//import javax.servlet.ServletOutputStream;

/**
 *
 * @author araa
 */
public class GenerarReporte {
    
    public void listaDeudores(){
        try{
            
            String url="/home/araa/planB/CFP1PLANB/src/reporte/ListadoDeudores.jasper";
            JasperReport reporte=(JasperReport)JRLoader.loadObjectFromFile(url);
            
            JasperPrint jp=JasperFillManager.fillReport(reporte, null, clases.Conectar.conexion());
            JasperViewer vi=new JasperViewer(jp,false);
            vi.setVisible(true);
//            JasperReport reporte=(JasperReport)JRLoader.loadObjectFromFile("ListadoDeudores.jasper");
            //JasperReport reporte=(JasperReport)JRLoader.loadObject("ListadoDeudores.jasper");
           /* Map parametro=new HashMap();
            
            //parametro.put("idPersona", "parametro del metodo en caso de tenerlo");            
            JasperPrint j= JasperFillManager.fillReport(reporte,null,clases.Conectar.conexion());
            JasperViewer jv=new JasperViewer(j, false);
            
            jv.setTitle("Reporte de pruebaa");
            jv.setVisible(true);*/
            
        }catch(JRException e){
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
    }
}
