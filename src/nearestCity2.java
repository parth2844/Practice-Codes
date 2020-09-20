//
//import java.util.*;
//// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
//// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
//// DEFINE ANY CLASS AND METHOD NEEDED
//// CLASS BEGINS, THIS CLASS IS REQUIRED
//class Solution
//{
//
//    public class Coordinate {
//        int x, y;
//
//        public Coordinate(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
//
//    public class City{
//        String name;
//        Coordinate coordinate;
//
//        public City(String name, Coordinate coordinate) {
//            this.name = name;
//            this.coordinate = coordinate;
//        }
//    }
//
//    public class XComparator implements Comparator<City>{
//
//        @Override
//        public int compare(City o1, City o2) {
//            if(o1.coordinate.x == o2.coordinate.x){
//                if(o1.coordinate.y == o2.coordinate.y){
//                    return o1.name.compareTo(o2.name);
//                }
//                return o1.coordinate.y - o2.coordinate.y;
//            }
//            return o1.coordinate.x - o2.coordinate.x;
//        }
//    }
//
//    public class YComparator implements Comparator<City>{
//
//
//        @Override
//        public int compare(City o1, City o2) {
//            if(o1.coordinate.y == o2.coordinate.y){
//                if(o1.coordinate.x == o2.coordinate.x){
//                    return o1.name.compareTo(o2.name);
//                }
//                return o1.coordinate.x - o2.coordinate.x;
//            }
//            return o1.coordinate.y - o2.coordinate.y;
//        }
//    }
//
//    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
//    List<String> closestStraightCity(int numOfCities, List<String> cities,
//                                     List<Integer> xCoordinates,
//                                     List<Integer> yCoordinates,
//                                     int numOfQueries,
//                                     List<String> queries)
//    {
//        // WRITE YOUR CODE HERE
//        List<City> xArr = new ArrayList<>();
//        List<City> yArr= new ArrayList<>();
//
//        for (int i =0; i<numOfCities;i++) {
//            xArr.add(new City(cities.get(i),new Coordinate(xCoordinates.get(i),yCoordinates.get(i))));
//            yArr.add(new City(cities.get(i),new Coordinate(xCoordinates.get(i),yCoordinates.get(i))));
//        }
//
//        Collections.sort(xArr,new XComparator());
//        Collections.sort(yArr,new YComparator());
//
//        Map<String,Integer> xName = new HashMap<>();
//        Map<String,Integer> yName = new HashMap<>();
//
//        for (int i =0; i<xArr.size();i++) {
//            xName.put(xArr.get(i).name,i);
//        }
//
//        for (int i =0; i<xArr.size();i++) {
//            yName.put(yArr.get(i).name,i);
//        }
//
//        List<String> ans= new ArrayList<>();
//
//        for(String query: queries) {
//            int minAns= Integer.MAX_VALUE;
//            String name = "NONE";
//            int minAns2 =0;
//            String name2;
//            Integer xPos = xName.get(query);
//
//            if(xPos==null) {
//                ans.add("NONE");
//                continue;
//            }
//
//            int x = xArr.get(xPos).coordinate.x;
//            int y = xArr.get(xPos).coordinate.y;
//
//            if(xPos>0 && xArr.get(xPos-1).coordinate.x==x &&  Math.abs(y- xArr.get(xPos-1).coordinate.y)<minAns){
//                minAns2= Math.abs(y-xArr.get(xPos-1).coordinate.y);
//                name2 = xArr.get(xPos-1).name;
//                if (minAns2==minAns) {
//                    if(name2.compareTo(name)<0) {
//                        name=name2;
//                    }
//                }
//                else {
//                    name = name2;
//                }
//                minAns = minAns2;
//            }
//
//            if(xPos<xArr.size()-1 && xArr.get(xPos+1).coordinate.x==x &&  Math.abs(y- xArr.get(xPos+1).coordinate.y)<minAns) {
//                minAns2= Math.abs(y-xArr.get(xPos+1).coordinate.y);
//                name2 = xArr.get(xPos+1).name;
//                if(minAns2==minAns) {
//                    if(name2.compareTo(name)<0) {
//                        name=name2;
//                    }
//                }
//                else {
//                    name = name2;
//                }
//                minAns=minAns2;
//            }
//
//            int yPos = yName.get(query);
//
//            if(yPos > 0 && yArr.get(yPos-1).coordinate.y == y && Math.abs(x- yArr.get(yPos-1).coordinate.x) < minAns) {
//                minAns2 = Math.abs(x-yArr.get(yPos-1).coordinate.x);
//                name2 = yArr.get(yPos-1).name;
//                if(minAns2 == minAns) {
//                    if(name2.compareTo(name) < 0) {
//                        name=name2;
//                    }
//                }
//                else {
//                    name = name2;
//                }
//                minAns = minAns2;
//            }
//
//            if (yPos < yArr.size() - 1 && yArr.get(yPos + 1).coordinate.y == y &&  Math.abs(x- yArr.get(yPos+1).coordinate.x) < minAns ) {
//                minAns2 = Math.abs(x-yArr.get(yPos + 1).coordinate.x);
//                name2 = yArr.get(yPos+1).name;
//                if (minAns2==minAns) {
//                    if (name2.compareTo(name) < 0) {
//                        name=name2;
//                    }
//                }
//                else {
//                    name = name2;
//                }
//                minAns = minAns2;
//            }
//            ans.add(name);
//        }
//        return ans;
//    }
//    // METHOD SIGNATURE ENDS
//}