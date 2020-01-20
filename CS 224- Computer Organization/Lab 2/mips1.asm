# allocate dynamic memory
sll $a0 $v0 2    # sll performs $a0 = $v0 x 2^2
li $v0 9    #9 is the system code for service(sbrk) whoes work is        
syscall     #to allocate dynamic memory

move $s1 $v0

la   $a0, octalNo




move $a0,$v0	
li $v0,1
syscall

j end
convertToDec:

li $v0,0 # the result
li $s3,0 # counts how many elements
add $s2,$0, $s1

loop1:
  lbu  $s4, 0($a0) 
  beq $s4, $0, done1
  subi $s4, $s4, 48         
  sw $s4, ($s1)  
  addi $s1, $s1, 4
  addi $a0, $a0, 1
  addi $s3, $s3, 1
  j loop1
  
done1:	

loop2:
   beq $s3, $0, done2
   add $s5,$0, $s3
   lw $s6, 0($s2)   
   
   loop3:
      beq $s5, 1 , done3
      mul $s6, $s6, 8
      subi $s5,$s5,1
      j loop3
      
   done3:  
    
   addi $s2, $s2, 4
   add $v0, $v0, $s6
   subi $s3, $s3, 1     
   j loop2
   
done2:
  jr   $ra	
  
     
   	        
end:	   
	    	     
	       .data
octalNo:   .asciiz "20"

