package sn.isi.Emploi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.isi.Emploi.model.Cv;
import sn.isi.Emploi.service.CvService;


import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/cvs")
public class CvController {
    @Autowired
    private CvService cvService;

    @PostMapping()
    public ResponseEntity<?> add(@RequestBody Cv cv) {
        Cv cv1 = cvService.add(cv);
        if (cv1 != null) {
            return new ResponseEntity<>(cv1, HttpStatus.OK);
        } else
        return new ResponseEntity<>(cv1, HttpStatus.BAD_REQUEST);
    }

    @GetMapping()
    public ResponseEntity<List<Cv>> getAll()
    {
      List<Cv> cv = cvService.getAll();
      if (cv != null) { return new ResponseEntity<>(cv,HttpStatus.OK); }
      else { return new ResponseEntity<>(HttpStatus.NOT_FOUND); }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Cv> getCv(@PathVariable Integer id) {
        Cv cv = cvService.getCv(id);
        if (cv != null ) { return new ResponseEntity<>(cv, HttpStatus.OK); }
        else { return new ResponseEntity<>(HttpStatus.NOT_FOUND); }
    }

   /* @GetMapping("/byNumber/{phoneNumber}")
    public ResponseEntity<?> getByPhone(@PathVariable String phoneNumber) {
        cv cv = cvService.getByPhoneNumber(phoneNumber);
        if (cv != null) { return new ResponseEntity<>(cv, HttpStatus.OK); }
        else { return new ResponseEntity<>(HttpStatus.NOT_FOUND); }
    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity<Cv> deleteById(@PathVariable Integer id)
    {
        cvService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Cv> fullUpdate(@Valid @RequestBody Cv cv) {
        Cv newCv = cvService.update(cv);
        if (newCv != null){
            return new ResponseEntity<>(newCv, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
     }
    
//    @GetMapping("/total/{id}")
//    public ResponseEntity<?> getTotal(@PathVariable Integer id)
//    {
//    	cv cv = cvService.getCv(id);
//    	if (cv != null) {
//        return new ResponseEntity<>(cv.cotisationTotale(),HttpStatus.OK);
//      } else {
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//      }
//    }

   /* @PatchMapping("/{phoneNumber}/{newPhoneNumber}")
    public ResponseEntity<cv> partialUpdate(@PathVariable String phoneNumber, @PathVariable String newPhoneNumber)
    {
        cv cv = cvService.getByPhoneNumber(phoneNumber);
        if (cv != null) {
            cv.setPhoneNumber(newPhoneNumber);
            cv newMember = cvService.update(cv);
            return new ResponseEntity<>(newMember, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }*/
    
     //get cv by function
    /*@GetMapping("/getByFunction/{function}")
    public ResponseEntity<?> getByFunction(@PathVariable String function) {
        List<cv> cvList = cvService.getByFunction(function);
        if (cvList != null) {
            return new ResponseEntity<>(cvList, HttpStatus.OK);
        }else
        return new ResponseEntity<List<cv>>(HttpStatus.NOT_FOUND);
    }*/
    
    //get cv by type (bureau, simple)
   /* @GetMapping("/getByType/{type}")
    public ResponseEntity<?> getByType(@PathVariable String type) {
    	List<cv> cvList = cvService.getByType(type);
    	if(cvList != null)
    	{
    		return new ResponseEntity<>(cvList, HttpStatus.OK);
    	}else
    	return new ResponseEntity<List<cv>>(HttpStatus.NOT_FOUND);
    	
    }
*/
    //get cvs by sex

}
