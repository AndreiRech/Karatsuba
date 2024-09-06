def multiplicar_binarios(bin1, bin2):
    resultado = bin(int(bin1, 2) * int(bin2, 2))[2:]
    return resultado

def comparar_resultado(resultado, valor_referencia):
    if resultado == valor_referencia:
        print("Os valores sao iguais!")
    else:
        print("Os valores são diferentes!")
        print(f"Resultado: {resultado}")
        print(f"Valor de referência: {valor_referencia}")
        
    
bin1 = '101010'
bin2 = '111111111111111'
valor_referencia = '101001111111111010110'

resultado = multiplicar_binarios(bin1, bin2)

comparar_resultado(resultado, valor_referencia)