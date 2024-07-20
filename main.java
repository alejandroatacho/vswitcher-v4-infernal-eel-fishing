//Variables
NPC fishingSpot = v.getNpc().findNearest(7676);
int hammer_slot = v.getInventory().slot(2347);
int infernal_eel_id = 21293;
int infernal_eel_slot = v.getInventory().slot(21293);
int infernal_eel_counter = v.getInventory().count(21293);

//fuck these are dangerous variables.
int while_loop_fighter = 0; 

//Methods down below
private void useSpecialAttack() {
    if (v.getCombat().specRemaining(100, 100)) {
        v.getCombat().spec(1);
    }
}

private void enableRunning() {
    if (client.getEnergy() == 10000) {
        v.getWalking().turnRunningOn();
    }
}

private void baitSpot() {
    if (!v.getInventory().inventoryFull() && v.getLocalPlayer().hasAnimation(-1) && !v.getWalking().isMoving()) {
        v.getFishing().bait(fishingSpot);
    }
}
private void convertEelsToTokkuls(){
    if (v.getInventory().inventoryFull() && v.getLocalPlayer().hasAnimation(-1) && !v.getWalking().isMoving()) {   
        int infernal_eel_counter = v.getInventory().count(infernal_eel_id); // Count the eels at the beginning
        while (while_loop_fighter <= infernal_eel_counter) {
            if (infernal_eel_counter != 0) {
                v.invoke("Use","<col=ff9040>Hammer</col>",0,25,hammer_slot,9764864,false);
                infernal_eel_slot = v.getInventory().slot(13339); //update the slot of the eel
                v.invoke("Use","<col=ff9040>Hammer</col><col=ffffff> -> <col=ff9040>Infernal eel</col>",0,58,27,9764864,false);
                while_loop_fighter++;
                infernal_eel_counter = v.getInventory().count(infernal_eel_id); //update the eel counter
            }
        }
    }
    else {
        baitSpot();
    }
}
useSpecialAttack();
enableRunning();
baitSpot();
convertEelsToTokkuls();