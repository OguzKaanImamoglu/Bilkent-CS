##1.3
	.text		
       	.globl __start	

__start:

	la $a0,prompt	# print prompt on terminal
	li $v0,4
	syscall
	
	li $v0,5	# syscall 5 reads an integer
	syscall
	move $s0,$v0	# $s0 holds number
	
	la $a0,prompt	# print prompt on terminal
	li $v0,4
	syscall
	
	li $v0,5	# syscall 5 reads an integer
	syscall
	move $s1,$v0	# $s1 holds number
	
	li $s2,0	# $s2 will be the division
	li $t3,0	# $s3 will be the remainder
	add $s4,$0,$s0 # $s4 is to remember initial value


loop:

	#slt  $t5, $s1, $s0 # counter less than result
	#beq  $t5, $0, done
	
	sub $s0,$s0,$s1
	addi $s2,$s2,1
	blt $s0,$s1 done
	
	
	j loop	
	
done:	
        la $a0,ans1	# print string before result
	li $v0,4
	syscall
	
	move $a0,$s2
	li $v0,1
	syscall	
	
	la $a0,ans2	# print string before result
	li $v0,4
	syscall
	
	move $a0,$s0
	li $v0,1
	syscall	
        

			.data
prompt:	.asciiz "Enter  number: "
ans1:	.asciiz "Division is "
ans2:	.asciiz "\nRemainder is "
result:	.space 12
