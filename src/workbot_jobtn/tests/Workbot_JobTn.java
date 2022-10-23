/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package workbot_jobtn.tests;

import api.deezer.DeezerApi;
import api.deezer.exceptions.DeezerException;
import api.deezer.objects.Album;
import api.deezer.objects.data.TrackData;
import workbot_jobtn.utils.Mail;
import workbot_jobtn.utils.MyDB;

/**
 *
 * @author Exon
 */
public class Workbot_JobTn {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws DeezerException {
        // TODO code application logic here
        System.out.println(MyDB.getInstance());
        
         DeezerApi deezerApi = new DeezerApi();

        Album album = deezerApi.album()
                .getById(302127)
                .execute();
        System.out.println(album);

        TrackData trackData = deezerApi.search()
                .searchTrack("eminem")
                .execute();
        System.out.println(trackData);
   
    }
    
}
