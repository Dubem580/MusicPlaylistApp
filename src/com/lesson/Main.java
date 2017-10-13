package com.lesson;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {
        // write your code here

        Album album = new Album("Off the Wall", "MJ");
        album.addSong("Girlfriend", 3.05);
        album.addSong("Off the Wall", 4.06);
        album.addSong("Rock with you", 3.40);
        album.addSong("Don't stop 'til you get enough", 6.05);
        album.addSong("Workin' day and night", 5.14);
        album.addSong("Get on the floor", 4.50);
        album.addSong("She's out of my life", 3.38);
        album.addSong("I can't help it", 4.29);
        album.addSong("It's the falling in love", 3.48);
        album.addSong("Burn this Disco out", 3.42);
        albums.add(album);

        album = new Album("Thriller", "MJ");
        album.addSong("Thriller", 5.58);
        album.addSong("Beat It", 4.18);
        album.addSong("The girl is mine", 3.42);
        album.addSong("Wanna be starting something", 6.03);
        album.addSong("Billie Jean", 4.54);
        album.addSong("Baby Be Mine", 4.20);
        album.addSong("Human Nature", 4.06);
        album.addSong("The Lady in my life", 4.59);
        album.addSong("P.Y.T", 3.59);
        albums.add(album);

        LinkedList<Song> playlist = new LinkedList<Song>();
        albums.get(0).addedPlaylist("Get on the floor", playlist);
        albums.get(0).addedPlaylist("Human Nature", playlist);
        albums.get(0).addedPlaylist("She's out of my life", playlist);
        albums.get(0).addedPlaylist(6,playlist);
        albums.get(0).addedPlaylist(2,playlist);
        albums.get(1).addedPlaylist(1,playlist);
        albums.get(1).addedPlaylist(6,playlist);
        albums.get(1).addedPlaylist(30,playlist);

        play(playlist);


    }

    private static void play(LinkedList<Song> playlist){
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;

        ListIterator<Song> listIterator = playlist.listIterator();
        if (playlist.size() == 0){
            System.out.println("no songs currently in playlist");
            return;
        } else {
            System.out.println("now playing " + listIterator.next().toString());
            printMenu();
        }
        while(!quit){
            int action = sc.nextInt();
            sc.nextLine();

            switch (action){
                case 0:
                    System.out.println("playlist complete.");
                    quit = true;
                    break;
                case 1:
                    if (!forward){
                        if (listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()){
                        System.out.println("now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("end of playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()){
                        System.out.println("now playing " + listIterator.previous().toString() + " track");
                    } else {
                        System.out.println(" reached to the start of the playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if (forward){
                        if (listIterator.hasPrevious()){
                            System.out.println("now replaying " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("start of the playlist");
                            }
                    } else{
                        if (listIterator.hasNext()){
                            System.out.println("now replaying " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("end of list");
                        }
                    }
                    break;
                case 4:
                    printList(playlist);
                    break;
                case 5:
                   printMenu();
                    break;
                case 6:
                    if (playlist.size() > 0){
                        listIterator.remove();
                        if (listIterator.hasNext()){
                            System.out.println("now playing " + listIterator.next());
                        } else if (listIterator.hasPrevious()){
                            System.out.println("now playing " + listIterator.previous());
                        }
                    }
                    break;
            }
        }
    }

    private static void printMenu(){
        System.out.println("Available actions:\npress");
        System.out.println("0 - Quit\n" +
                "1 - Next song\n" +
                "2 - Previous song\n" +
                "3 - Replay the current song\n" +
                "4 - List songs in the playlist\n" +
                "5 - Print available actions\n" +
                "6 - Delete current song from playlist");
    }

    private static void printList(LinkedList<Song> playlist){
        Iterator<Song> iterator = playlist.iterator();
        System.out.println("*****************");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("*****************");
    }

}