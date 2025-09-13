package com.problemsolving.mobiquity;

class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        int c=0;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n+1;j++)
            {
                String sub=s.substring(i,j);
                if(f(sub))
                    c+=1;
            }
        }
        return c;
    }
    public boolean f(String s)
    {
        int i=0;
        int j=s.length()-1;
        while(i<=j)
        {
            char a=s.charAt(i);
            char b=s.charAt(j);
            if(a!=b)
                return false;
            else
            {
                i++;
                j--;
            }
        }
        return true;
    }
}