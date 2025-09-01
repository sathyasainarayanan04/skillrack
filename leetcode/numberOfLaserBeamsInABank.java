class Solution {
    public int numberOfBeams(String[] bank) {
        int prevSecurityDeviceFrequency= 0;
        int answer = 0;
        for(String s : bank){
            int currentSecurityDeviceFrequency = 0;
            for(char c : s.toCharArray()){
                if(c=='1'){
                    currentSecurityDeviceFrequency++;
                }
            }
            if(currentSecurityDeviceFrequency > 0){
                answer+=(currentSecurityDeviceFrequency*prevSecurityDeviceFrequency);
                prevSecurityDeviceFrequency = currentSecurityDeviceFrequency;
            }
        }
        return answer;
    }
}
