package com.mini.arcade.service;

import com.mini.arcade.dto.StrengthenResDto;
import com.mini.arcade.dto.UserResDto;
import com.mini.arcade.dto.WeaponResDto;
import com.mini.arcade.entity.Weapon;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StrengthenService {

    Map<Integer, Weapon> weaponMap = new HashMap<>();

    public StrengthenResDto initStatus() {
        new Weapon(1, "", 0.99, 400, "");
        weaponMap.put(1, new Weapon(1, "", 0.99, 500, ""));
        weaponMap.put(2, new Weapon(2, "", 0.95, 1000, ""));
        weaponMap.put(3, new Weapon(3, "", 0.90, 2500, ""));
        weaponMap.put(4, new Weapon(4, "", 0.80, 5000, ""));
        weaponMap.put(5, new Weapon(5, "", 0.70, 10000, ""));
        weaponMap.put(6, new Weapon(6, "", 0.60, 25000, ""));
        weaponMap.put(7, new Weapon(7, "", 0.50, 70000, ""));
        weaponMap.put(8, new Weapon(8, "", 0.40, 200000, ""));
        weaponMap.put(9, new Weapon(9, "", 0.30, 500000, ""));
        weaponMap.put(10, new Weapon(10, "", 0.25, 1500000, ""));
        weaponMap.put(11, new Weapon(11, "", 0.15, 5000000, ""));
        weaponMap.put(12, new Weapon(12, "", 0.10, 20000000, ""));
        weaponMap.put(13, new Weapon(13, "", 0.5, 100000000, ""));
        weaponMap.put(14, new Weapon(14, "", 0.3, 500000000, ""));
        weaponMap.put(15, new Weapon(15, "", 0.0, 0, ""));

        UserResDto userResDto = new UserResDto(3000);
        WeaponResDto weaponResDto = weaponMap.get(1).toDto();
        StrengthenResDto strengthenResDto = new StrengthenResDto(weaponResDto, userResDto);

        return strengthenResDto;
    }
}
